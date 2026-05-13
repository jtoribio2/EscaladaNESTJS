import { Test, TestingModule } from '@nestjs/testing';
import { TipusViaController } from './tipus-via.controller';
import { TipusViaService } from './tipus-via.service';

describe('TipusViaController', () => {
  let controller: TipusViaController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [TipusViaController],
      providers: [TipusViaService],
    }).compile();

    controller = module.get<TipusViaController>(TipusViaController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
